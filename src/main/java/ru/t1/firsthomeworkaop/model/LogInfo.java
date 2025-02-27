package ru.t1.firsthomeworkaop.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Справочник учёта времени выполнения методов.
 * Представление записи справочника my_db.loginfo.
 */
@Entity
@Table(name = "loginfo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LogInfo {

    /**
     * ID метода.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Имя метода.
     */
    @Column(name = "name_method")
    private String nameMethod;

    /**
     * Длительность выполнения метода в миллисекундах.
     */
    @Column(name = "duration")
    private Long duration;
}
