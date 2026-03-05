package com.example.expenses.utils;

import java.util.logging.Level;

public class CustomLevel extends Level {
    public static final Level TEST = new CustomLevel("TEST", 850);
    protected CustomLevel(String name, int value) {
        super(name, value);
    }
    protected Object readResolve() {
        // Если восстанавливаемый объект - это наш TEST (значение 350, имя "TEST")
        if (this.intValue() == 850 && "TEST".equals(this.getName())) {
            return TEST;  // отдаём оригинальный объект вместо копии
        }
        return this;  // если это другой уровень, возвращаем как есть
    }
}