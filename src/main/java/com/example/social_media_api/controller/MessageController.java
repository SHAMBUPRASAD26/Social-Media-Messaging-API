package com.example.social_media_api.controller;

import com.example.social_media_api.entity.Message;
import com.example.social_media_api.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class MessageController {

    @Autowired
    private MessageService service;

    @PostMapping("/messages")
    public ResponseEntity<?> create(@RequestBody Message message) {
        Message saved = service.create(message);
        if (saved == null) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/messages")
    public List<Message> getAll() {
        return service.getAll();
    }

    @GetMapping("/messages/{id}")
    public Message getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @DeleteMapping("/messages/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        int result = service.delete(id);
        return result == 0 ? ResponseEntity.ok().build() : ResponseEntity.ok(1);
    }

    @PatchMapping("/messages/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id,
                                    @RequestBody Map<String, String> body) {
        int result = service.update(id, body.get("message_text"));
        if (result == 0) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(1);
    }

    @GetMapping("/accounts/{id}/messages")
    public List<Message> getByUser(@PathVariable Integer id) {
        return service.getByUser(id);
    }
}
