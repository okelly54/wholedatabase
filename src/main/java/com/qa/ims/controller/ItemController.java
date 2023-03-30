package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

public class ItemController implements CrudController<Item> {

	public static final Logger LOGGER = LogManager.getLogger();

	private ItemDAO itemDAO;
	private Utils utils;

	public ItemController(ItemDAO itemDAO, Utils utils) {
		super();
		this.itemDAO = itemDAO;
		this.utils = utils;
	}

	// Reads all items to logger

	@Override
	public List<Item> readAll() {
		List<Item> items = itemDAO.readAll();
		for (Item item : items) {
			LOGGER.info(item);
		}
		return items;
	}

	// Creates item by taking user input

	@Override
	public Item create() {
		LOGGER.info("Please enter a name: ");
		String name = utils.getString();
		LOGGER.info("Please enter a cost: ");
		Float cost = utils.getFloat();
		Item item = itemDAO.create(new Item(name, cost));
		LOGGER.info("Item created");
		return item;
	}

	// Updates existing item by taking in user input

	@Override
	public Item update() {
		LOGGER.info("Please enter the item id to update the item: ");
		Long itemid = utils.getLong();
		LOGGER.info("Please enter a name");
		String name = utils.getString();
		LOGGER.info("Please enter a cost: ");
		Float cost = utils.getFloat();
		Item item = itemDAO.update(new Item(itemid, name, cost));
		LOGGER.info("Item updated");
		return item;
	}

	// Deletes an existing item by its id

	@Override
	public int delete() {
		LOGGER.info("Please enter the item id to delete the item: ");
		Long itemid = utils.getLong();
		return itemDAO.delete(itemid);
	}

}
