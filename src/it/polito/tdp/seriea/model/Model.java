package it.polito.tdp.seriea.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jgrapht.Graphs;
import org.jgrapht.WeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.seriea.db.SerieADAO;

public class Model {
	
	private SerieADAO dao;
	private WeightedGraph<Season,DefaultWeightedEdge> grafo;
	
	public Model(){
		this.dao= new SerieADAO();
	}
	
	public void creaGrafo(){
		this.grafo= new SimpleWeightedGraph<Season,DefaultWeightedEdge>(DefaultWeightedEdge.class);
		Graphs.addAllVertices(grafo, dao.listSeasons());
		
		Map<Integer, Season> stag = new HashMap<>();
		
		for(Season sss : grafo.vertexSet())
			stag.put(sss.getSeason(), sss);
		
		for(Season s : grafo.vertexSet()){
			for(Season ss : grafo.vertexSet()){
				Season s1 = stag.get(s.getSeason());
				Season s2 = stag.get(ss.getSeason());
				List<Team> t1= dao.listTeams(s1.getSeason());
				List<Team> t2 = dao.listTeams(s2.getSeason());
				int temp=0;
				for(Team t : t1){
					for(Team tt: t2){
						if(t.equals(tt)){
							temp++;
						}
					}
				}
				if(!s.equals(ss)){
					DefaultWeightedEdge e = grafo.addEdge(s, ss);
					//System.out.println(e);
					if(e!=null){
						grafo.setEdgeWeight(e, temp);
						//System.out.println(grafo.getEdgeWeight(e));
					}
				}
			}
		}
//		for(Season s : grafo.vertexSet()){
//			System.out.println(grafo.edgesOf(s));
//		}
	}
	
	public Set<Season> getStagioni(){
		if(grafo==null)
			this.creaGrafo();
		return grafo.vertexSet();
	}
	
	public List<Season2> getSquadre(Season s){
		if(grafo==null)
			this.creaGrafo();
		List<Season2> l = new ArrayList<>();
		for(DefaultWeightedEdge e : grafo.edgesOf(s)){
			if(grafo.getEdgeTarget(e).equals(s)){
				Season2 ss = new Season2(grafo.getEdgeSource(e), grafo.getEdgeWeight(e));
				l.add(ss);
				
				//System.out.println(grafo.getEdgeSource(e));
			}
			else if(grafo.getEdgeSource(e).equals(s)){
				Season2 ss = new Season2(grafo.getEdgeTarget(e), grafo.getEdgeWeight(e));
				l.add(ss);
				//System.out.println(grafo.getEdgeTarget(e));
			}
			
		}
		Collections.sort(l);
		for(Season2 s2 : l){
			System.out.println(s2.toString());
		}
		return l;
	}

}
