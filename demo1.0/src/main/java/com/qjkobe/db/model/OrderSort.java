package com.qjkobe.db.model;

public enum OrderSort {

	ASC("asc"),

	DESC("desc");

	private String orderType;

	private OrderSort(String orderType) {
		this.orderType = orderType;
	}

	public String getType() {
		return orderType;
	}

}
