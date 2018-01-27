package com.example.demo.model;

import java.sql.Timestamp;

public class Comment {
    int commentId;
    int userId;
    int productId;
    String content;
    Timestamp dateTime;
    int repyTo;
}
