package com.sotong.projectcms.persistence.repository.message;

import com.sotong.projectcms.persistence.entity.message.Notification;
import com.sotong.projectcms.persistence.entity.message.NotificationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Samuel Butta
 */
@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    public List<Notification> findAllByStatus(NotificationStatus notificationStatus);


    public List<Notification> findAllByStatusNot(NotificationStatus notificationStatus);

}
