package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private Utils utils;

	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	// Reads orders to logger

	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	// Creates order by taking user input

	@Override
	public Order create() {
		LOGGER.info("Please enter the id of the customer making the order: ");
		Long customerid = utils.getLong();
		LOGGER.info("Please enter the id of an item to add: ");
		Long itemid = utils.getLong();
		LOGGER.info("Please enter the total: ");
		Float total = utils.getFloat();
		Order order = orderDAO.create(new Order(customerid, itemid, total));
		LOGGER.info("Order created");

		System.out.println("What items were in this order:");

		return order;
	}

	@Override
	public Order update() {
		LOGGER.info("Please enter the id of the order to update: ");
		Long orderid = utils.getLong();
		LOGGER.info("Please enter the id of the customer: ");
		Long customerid = utils.getLong();

		System.out.println("Enter the id of the item to add: ");
		Long itemid = utils.getLong();

		LOGGER.info("Please enter the total: ");
		Float total = utils.getFloat();
		Order order = orderDAO.create(new Order(orderid, customerid, itemid, total));
		LOGGER.info("Order updated");
		// could have it where we use the customerid not the orderid to find the order
		// but if a customer can have multiple orders this doesn't work
		return order;
	}

	// Deletes an order by the id

	@Override
	public int delete() {
		LOGGER.info("Please enter the order id for the order to be deleted: ");
		Long orderid = utils.getLong();
		return orderDAO.delete(orderid);
	}

}
