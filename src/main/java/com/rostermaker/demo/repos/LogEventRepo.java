package com.rostermaker.demo.repos;

import com.rostermaker.demo.models.logEvent.LogEvent;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LogEventRepo extends CrudRepository<LogEvent, Long> {

    List<LogEvent> findAll();

    List<LogEvent> findAllBy(Sort sort);
}
