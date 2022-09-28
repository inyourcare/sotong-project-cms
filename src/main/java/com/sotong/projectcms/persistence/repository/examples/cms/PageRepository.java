package com.sotong.projectcms.persistence.repository.examples.cms;

import com.sotong.projectcms.persistence.entity.examples.cms.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Samuel Butta
 */
@Repository
public interface PageRepository extends JpaRepository<Page, Long> {

    public Optional<Page> getByUrl(String url);

    public List<Page> findByParentPage(Page parentPage);
}
