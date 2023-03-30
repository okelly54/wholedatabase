package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemOrderDAO;
import com.qa.ims.persistence.domain.ItemOrder;
import com.qa.ims.utils.Utils;

public class ItemOrderController implements CrudController<ItemOrder> {

	public static final Logger LOGGER = LogManager.getLogger();

	private ItemOrderDAO itemorderDAO;
	private Utils utils;

	public ItemOrderController(ItemOrderDAO itemorderDAO, Utils utils) {
		super();
		this.itemorderDAO = itemorderDAO;
		this.utils = utils;
	}

	@Override
	public List<ItemOrder> readAll() {
		List<ItemOrder> itemorders = itemorderDAO.readAll();
		for (ItemOrder itemorder : itemorders) {
			LOGGER.info(itemorder);
		}
		return itemorders;
	}

	@Override
	public ItemOrder create() {
		LOGGER.info("Please enter the orderid: ");
		Long orderid = utils.getLong();
		LOGGER.info("Please enter the item id: ");
		Long itemid = utils.getLong();
		Float total = ItemOrder.getTotal();
		ItemOrder itemorder = itemorderDAO.create(new ItemOrder(orderid, itemid, total));
		LOGGER.info("Item created");
		return itemorder;
	}

	@Override
	public ItemOrder update() {
		LOGGER.info("Please enter the itemorderid of the itemorder to update: ");
		Long itemorderid = utils.getLong();
		LOGGER.info("Please enter the order id: ");
		Long orderid = utils.getLong();
		// rest is unnecessary but keeps causing errors understandably
		LOGGER.info("Please enter the item id: ");
		Long itemid = utils.getLong();
		LOGGER.info("Please enter the total: ");
		Float total = utils.getFloat();
//		String ans = "y";
//		while (ans == "y"); {
//			LOGGER.info("Would you like to add another order: y/n");
//			ans = utils.getString();
//			LOGGER.info("Please enter an item id: ");
//			Long itemid = utils.getLong();

//		}
		ItemOrder itemorder = itemorderDAO.update(new ItemOrder(itemorderid, orderid, itemid, total));
		LOGGER.info("Itemorder updated");
		return itemorder;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the orderid of the itemorder to be deleted: ");
		Long orderid = utils.getLong();
		return itemorderDAO.delete(orderid);
	}

}
