package com.example.demo6.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Student {
    @Id
    private String id;
    @NonNull
    private String name;
    @NonNull
    private int caMarks;
    @NonNull
    private int practicalMarks;
    @NonNull
    private int theoryMarks;
    @NonNull
    private double finalMarks;

}
