package com.passwordgenerator.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Parameters {
    private int length;
    private int specialCharCount;
    private int numberCount;
}
