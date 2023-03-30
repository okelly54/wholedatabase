package com.qa.ims.persistence.domain;

public class Item {
	// copies customer

	private Long itemid;
	private String name;
	private Float cost;

	public Item(String name, Float cost) {
		this.setName(name);
		this.setCost(cost);
	}

	public Item(Long itemid, String name, Float cost) {
		this.setItemId(itemid);
		this.setName(name);
		this.setCost(cost);
	}

	public Long getItemId() {
		return itemid;
	}

	public void setItemId(Long itemid) {
		this.itemid = itemid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "id:" + itemid + " item name:" + name + " cost:" + cost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemid == null) ? 0 : itemid.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
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
		Item other = (Item) obj;
		if (getName() == null) {
			if (other.getName() != null)
				return false;
		} else if (!getName().equals(other.getName()))
			return false;
		if (getCost() == null) {
			if (other.getCost() != null)
				return false;
		}

		if (itemid == null) {
			if (other.itemid != null)
				return false;
		} else if (!itemid.equals(other.itemid))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		}
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		return true;
	}

}
