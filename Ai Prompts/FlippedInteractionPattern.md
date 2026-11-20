# The Flipped Interaction pattern

### My prompt

```text
Context: I'm a student in a Java course at Year Up. I'm learning abstract
classes and abstract methods.

Task: Quiz me on abstract classes and abstract methods, one question at a time.
Start with easy questions and get harder. Ask 8 questions.

Constraints: Ask only ONE question at a time, and wait for my answer before the
next one. Don't give me hints or the answer before I try. After each answer,
tell me if I was right and explain why in one or two sentences. Don't write
code for me.

Format: Multiple choice with four choices labeled A, B, C and D. Start each
question with "Question 1 of 8", and so on. At the end, give me my score, the
topics I missed, and which sections of my workbook to reread.
```

### The four pieces

- **Context:** tells the AI who I am and what I'm studying.
- **Task:** what I want it to do. Instead of explaining, it quizzes me.
- **Constraints:** one question at a time, no hints before I answer, and no code written for me.
- **Format:** multiple choice with a score at the end.

### How it went

I got a perfect score, 8 out of 8. I answered every question from memory
without looking at my code or the workbook. The AI didn't find any problem
areas, so I didn't need to go back and reread any sections. The quiz covered
what makes a class abstract, why an abstract method has nobody, why you can't
create an instance of an abstract class, and what a child class has to do. That
matches what I found when I made `Asset` abstract and wrote `Cash`.