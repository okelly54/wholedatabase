package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.ItemOrder;
import com.qa.ims.utils.DBUtils;

public class ItemOrderDAO implements Dao<ItemOrder> {

	public static final Logger LOGGER = LogManager.getLogger();

	private ItemOrderDAO itemid;
	private DBUtils utils;

	public ItemOrderDAO() {
		super();
		this.itemid = itemid;
	}

	@Override
	public ItemOrder modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long itemorderid = resultSet.getLong("itemorderid");
		Long orderid = resultSet.getLong("orderid");
		Long itemid = resultSet.getLong("itemid");
		Float total = resultSet.getFloat("total");

		return new ItemOrder(itemorderid, orderid, itemid, total);
	}

	@Override
	public List<ItemOrder> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM itemorder");) {
			List<ItemOrder> itemorders = new ArrayList<>();
			while (resultSet.next()) {
				itemorders.add(modelFromResultSet(resultSet));
			}
			return itemorders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public ItemOrder readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery("SELECT * FROM itemorder ORDER BY orderid DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public ItemOrder calcTotal(Long itemorderid) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"SELECT sum(item.cost) itemcost FROM item,itemorder WHERE itemorder.itemid = item.itemid AND itemorder.orderid = ?;");) {
			statement.setLong(1, itemorderid);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;

	}

	@Override
	public ItemOrder create(ItemOrder itemorder) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO itemorder(orderid, itemid) VALUES (?, ?)");) {
			statement.setLong(1, itemorder.getOrderId());
			statement.setLong(2, itemorder.getItemId());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public ItemOrder read(Long orderid) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("SELECT * FROM itemorder WHERE orderid = ?");) {
			statement.setLong(1, orderid);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public ItemOrder update(ItemOrder itemorder) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE itemorder SET itemid = ? WHERE orderid = ?");) {
			statement.setLong(1, itemorder.getItemId());
			statement.setLong(2, itemorder.getOrderId());
			return read(itemorder.getItemOrderId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public int delete(long orderid) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("DELETE FROM itemorder WHERE itemorderid = ?");) {
			statement.setLong(1, orderid);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	// run the command to get the total
// get the total to be output within that same method

// selects items where id ?
// select sum(cost)

// select item.cost FROM item,itemorder WHERE itemorder.itemid = item.id AND
// itemorder.orderid = ?
// list of all costs for that specific order
// select sum(item.cost) FROM item,itemorder WHERE itemorder.itemid = item.id
// AND itemorder.orderid = ?

}
