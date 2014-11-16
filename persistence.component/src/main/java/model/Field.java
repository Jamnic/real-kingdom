package model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import model.embedded.Coords;
import model.enums.ProductionFacility;
import model.enums.RoadType;
import model.enums.TerrainType;

/**
 * 1.0003 Field
 * 
 * Represents single immovable place on map.
 */
@Entity
@Table
public class Field {

	/* ========== Fields ========== */
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Enumerated(EnumType.STRING)
	private TerrainType terrainType;

	@Embedded
	private Coords coords;

	@OneToOne
	private Creature creature;

	@OneToOne
	private Sprite sprite;

	@Enumerated
	private RoadType road;

	@OneToOne
	private Settlement settlement;

	@Enumerated
	private ProductionFacility productionFacility;

	@ManyToOne
	private Board board;

	/* ========== Properties ========== */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TerrainType getTerrainType() {
		return terrainType;
	}

	public void setTerrainType(TerrainType terrainType) {
		this.terrainType = terrainType;
	}

	public Coords getCoords() {
		return coords;
	}

	public void setCoords(Coords coords) {
		this.coords = coords;
	}

	public Creature getCreature() {
		return creature;
	}

	public void setCreature(Creature creature) {
		this.creature = creature;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	public RoadType getRoad() {
		return road;
	}

	public void setRoad(RoadType road) {
		this.road = road;
	}

	public Settlement getSettlement() {
		return settlement;
	}

	public void setSettlement(Settlement settlement) {
		this.settlement = settlement;
	}

	public ProductionFacility getProductionFacility() {
		return productionFacility;
	}

	public void setProductionFacility(ProductionFacility productionFacility) {
		this.productionFacility = productionFacility;
	}
}
