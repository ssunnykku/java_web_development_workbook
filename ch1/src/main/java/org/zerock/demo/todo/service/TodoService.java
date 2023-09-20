package org.zerock.demo.todo.service;


import org.zerock.demo.todo.dtd.TodoDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum TodoService {
    INSTANCE;    // 한 개만 지정, 하나의 객체만을 생성해 사용 (싱글톤 패턴)

    public void register(TodoDTO todoDTO) {
        System.out.println("DEBUG............." + todoDTO);
    }

    public List<TodoDTO> getList() {

        List<TodoDTO> todoDTOS = IntStream.range(0,10).mapToObj(i->{
            TodoDTO dto = new TodoDTO();

            dto.setTno((long)i);
            dto.setTitle("Todo.."+i);
            dto.setDueDate(LocalDate.now());

            return dto;
        }).collect(Collectors.toList());

        return todoDTOS;
    }

    // 특정한 번호의 TodoDTO를 구하는 기능
    public TodoDTO get(Long tno) {
        TodoDTO dto = new TodoDTO();
        dto.setTno(tno);
        dto.setTitle("Sample Todo");
        dto.setDueDate(LocalDate.now());
        dto.setFinished(true);

        return dto;
    }
}

