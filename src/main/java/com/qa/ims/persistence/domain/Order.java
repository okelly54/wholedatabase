package com.qa.ims.persistence.domain;

public class Order {

	protected Long orderid;
	protected Long customerid;
	protected Long itemid;
	protected Float total;

	public Order(Long customerid, Long itemid, Float total) {
		this.setCustomerId(customerid);
		this.setItemId(itemid);
		this.setTotal(total);
	}

	public Order(Long orderid, Long customerid, Long itemid, Float total) {
		this.setOrderId(orderid);
		this.setCustomerId(customerid);
		this.setItemId(itemid);
		this.setTotal(total);
	}

	public Long getOrderId() {
		return orderid;
	}

	public void setOrderId(Long orderid) {
		this.orderid = orderid;
	}

	public Long getCustomerId() {
		return customerid;
	}

	public void setCustomerId(Long customerid) {
		this.customerid = customerid;
	}

	public Long getItemId() {
		return itemid;
	}

	public void setItemId(Long itemid) {
		this.itemid = itemid;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "id:" + orderid + "customer id:" + customerid + "item id:" + itemid + "total:" + total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderid == null) ? 0 : orderid.hashCode());
		result = prime * result + ((customerid == null) ? 0 : customerid.hashCode());
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
		Order other = (Order) obj;
		if (getTotal() == null) {
			if (other.getTotal() != null)
				return false;
		}
		if (getCustomerId() == null) {
			if (other.getCustomerId() != null)
				return false;
		}
		if (getItemId() == null) {
			if (other.getItemId() != null)
				return false;
		}
		if (orderid == null) {
			if (other.orderid != null)
				return false;
		} else if (!orderid.equals(other.orderid))
			return false;
		if (customerid == null) {
			if (other.customerid != null)
				return false;
		}
		if (itemid == null) {
			if (other.itemid != null)
				return false;
		}

		return true;
	}

}
