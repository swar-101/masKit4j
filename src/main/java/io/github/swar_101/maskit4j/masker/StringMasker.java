package io.github.swar_101.maskit4j.masker;

// TODO: Create a Javadoc for this class
public class StringMasker {

    public static final String MASKING_INPUT_NULL_MSG = "The input for masking cannot be null";
    public static final String MASKING_INDICES_POSITIVE_AND_NON_ZERO_MSG = "The 'maskFrom' index must be positive and non-zero.";
    public static final String MASK_FROM_EXCEEDS_INPUT_LENGTH_MSG = "The 'maskFrom' index exceeds input length.";
    public static final String MASK_TILL_NON_ZERO_MSG = "The 'maskTill' index must be non-zero.";
    public static final String MASK_TILL_EXCEEDS_INPUT_LENGTH_MSG = "The 'maskTill' index exceeds input length";
    public static final String MASK_FROM_EXCEEDS_MASK_TILL_MSG = "The 'maskFrom' index cannot exceed the 'maskTill' index";

    // TODO:
    //  1. Review if this method is production ready and performant.
    //  2. Write JUnits for testing all the edge cases.
    //  3. Create a Javadoc for this method.
    public static String mask(String input, int maskFrom, int maskTill) {
        if (input == null) throw new IllegalArgumentException(MASKING_INPUT_NULL_MSG);
        if (maskFrom <= 0) throw new IllegalArgumentException(MASKING_INDICES_POSITIVE_AND_NON_ZERO_MSG);
        if (maskFrom > input.length()) throw new IllegalArgumentException(MASK_FROM_EXCEEDS_INPUT_LENGTH_MSG);
        if (maskTill == 0) throw new IllegalArgumentException(MASK_TILL_NON_ZERO_MSG);
        if (maskTill > input.length() || (maskTill < 0 && maskTill < -input.length()))
            throw new IllegalArgumentException(MASK_TILL_EXCEEDS_INPUT_LENGTH_MSG);

        if (maskTill < 0 && maskTill > -input.length()) {
            maskTill = input.length() + maskTill + 1;
        } else if (maskFrom > maskTill) {
            throw new IllegalArgumentException(MASK_FROM_EXCEEDS_MASK_TILL_MSG);
        }

        StringBuilder maskedInput = new StringBuilder();
        String leftSide = input.substring(0, maskFrom - 1);
        String rightSide = input.substring(maskTill);

        String maskedPart;
        if (maskTill == input.length())
            maskedPart = "*".repeat(input.substring(maskFrom - 1).length());
        else
            maskedPart = "*".repeat(input.substring(maskFrom - 1, maskTill).length());

        return maskedInput.append(leftSide).append(maskedPart).append(rightSide).toString();
    }

    // TODO: Create a Javadoc for this method.
    public static String mask(String input) {
        return "*".repeat(input.length());
    }
}