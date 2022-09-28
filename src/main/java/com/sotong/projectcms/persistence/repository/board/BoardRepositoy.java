package com.sotong.projectcms.persistence.repository.board;

import com.sotong.projectcms.persistence.entity.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepositoy extends JpaRepository<Board, Long> {
}
