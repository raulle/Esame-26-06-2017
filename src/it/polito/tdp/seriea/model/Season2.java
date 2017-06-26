package it.polito.tdp.seriea.model;

public class Season2 implements Comparable<Season2> {
	
	private Season season;
	private double squadreComuni;

	public Season2(Season season, double squadreComuni) {
		super();
		this.season = season;
		this.squadreComuni=squadreComuni;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	public double getSquadreComuni() {
		return squadreComuni;
	}

	public void setSquadreComuni(double squadreComuni) {
		this.squadreComuni = squadreComuni;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(squadreComuni);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((season == null) ? 0 : season.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Season2 other = (Season2) obj;
		if (Double.doubleToLongBits(squadreComuni) != Double.doubleToLongBits(other.squadreComuni))
			return false;
		if (season == null) {
			if (other.season != null)
				return false;
		} else if (!season.equals(other.season))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Stagione: "+this.season.getDescription()+" Numero di squadre in comune: "+squadreComuni;
	}

	@Override
	public int compareTo(Season2 s2) {
		// TODO Auto-generated method stub
		return this.season.getSeason()-s2.getSeason().getSeason();
	}
	
	

}
	