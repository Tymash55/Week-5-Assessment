package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="items")

public class ListItem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="TEAM")
	private String team;
	
	@Column(name="TITLES")
	private int titles;
	public ListItem(String team, int titles) {
		super();
		
		this.team = team;
		this.titles = titles;
	}
	public ListItem() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTeamName() {
		return team;
	}
	public void setTeamName(String teamName) {
		this.team = teamName;
	}
	public int getTitles() {
		return titles;
	}
	public void setTitles(int titles) {
		this.titles = titles;
	}
	
	public String returnItemDetails() {
		return team + " have won " + titles + " Super Bowls";
	}

}
