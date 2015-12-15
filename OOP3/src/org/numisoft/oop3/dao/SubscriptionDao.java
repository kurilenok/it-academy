package org.numisoft.oop3.dao;

import java.sql.Connection;
import java.util.List;

import org.numisoft.oop3.dto.Subscription;
import org.numisoft.oop3.dto.User;

public interface SubscriptionDao {

	public List<Subscription> getSubscriptionByUser(Connection connection, User user);

	public void addSubscription(Connection connection, int user_id, int periodical_id);

	public void removeSubscription(Connection connection, int id);

}
