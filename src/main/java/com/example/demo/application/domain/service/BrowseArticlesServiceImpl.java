package com.example.demo.application.domain.service;

import com.example.demo.application.port.in.BrowseArticlesService;
import com.example.demo.application.port.out.UpdateUserArticlesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrowseArticlesServiceImpl implements BrowseArticlesService {

  private final UpdateUserArticlesService updateUserArticlesService;

}
