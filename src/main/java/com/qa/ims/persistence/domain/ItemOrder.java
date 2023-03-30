package com.qa.ims.persistence.domain;

public class ItemOrder {

	private Long itemorderid;
	private Long orderid;
	private Long itemid;
	private static Float total;
	// total made static to fix an issue

	public ItemOrder(Long orderid, Long itemid, Float total) {
		this.setOrderId(orderid);
		this.setItemId(itemid);
		this.setTotal(total);
	}

	public ItemOrder(Long itemorderid, Long orderid, Long itemid, Float total) {
		this.setItemOrderId(itemorderid);
		this.setOrderId(orderid);
		this.setItemId(itemid);
		this.setTotal(total);
	}

	public Long getItemOrderId() {
		return itemorderid;
	}

	public void setItemOrderId(Long itemorderid) {
		this.itemorderid = itemorderid;
	}

	public Long getOrderId() {
		return orderid;
	}

	public void setOrderId(Long orderid) {
		this.orderid = orderid;
	}

	public Long getItemId() {
		return itemid;
	}

	public void setItemId(Long itemid) {
		this.itemid = itemid;
	}

	public static Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "id:" + itemorderid + "order id:" + orderid + "item id:" + itemid + "total:" + total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemorderid == null) ? 0 : itemorderid.hashCode());
		result = prime * result + ((orderid == null) ? 0 : orderid.hashCode());
		result = prime * result + ((itemid == null) ? 0 : itemid.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
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
		ItemOrder other = (ItemOrder) obj;
		if (getTotal() == null) {
			if (other.getTotal() != null)
				return false;
		}
		if (getOrderId() == null) {
			if (other.getOrderId() != null)
				return false;
		}
		if (getItemId() == null) {
			if (other.getItemId() != null)
				return false;
		}
		if (itemorderid == null) {
			if (other.itemorderid != null)
				return false;
		} else if (!itemorderid.equals(other.itemorderid))
			return false;
		if (orderid == null) {
			if (other.orderid != null)
				return false;
		}
		if (itemid == null) {
			if (other.itemid != null)
				return false;
		}

		return true;
	}

}
