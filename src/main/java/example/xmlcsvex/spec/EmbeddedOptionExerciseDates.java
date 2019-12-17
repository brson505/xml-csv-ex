package example.xmlcsvex.spec;

import lombok.ToString;

@ToString
public class EmbeddedOptionExerciseDates {
    public MaxOccursTextElement exerciseDates;
    public FirstExerciseDate firstExerciseDate;
    public LastExerciseDate lastExerciseDate;
    public ExpirationTime expirationTime;
    public DateAdjustments dateAdjustments;
}
