package ru.t1.firsthomeworkaop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.t1.firsthomeworkaop.model.LogInfo;

@Repository
public interface LogInfoRepository extends JpaRepository<LogInfo, Long> {

}
