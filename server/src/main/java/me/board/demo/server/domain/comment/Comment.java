package me.board.demo.server.domain.comment;

import javax.persistence.*;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class Comment {
  @Id
  @GeneratedValue
  private Long id;
  private String content;
}
