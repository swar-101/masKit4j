To help developers understand and implement masking for different types of phone numbers, it’s essential to categorize them into distinct types based on their characteristics. This stratification will allow you to apply specialized rules and validation patterns for each type. Below, I have outlined how you can stratify phone numbers into various categories, along with the corresponding patterns and formats.

### 1. **Mobile Numbers**
   - **Description:** These are standard personal phone numbers assigned to mobile devices.
   - **Pattern:** Mobile numbers are typically 10 digits long in many countries, but the length can vary (e.g., 7-10 digits).
   - **Example:** `+1 212-555-1234` (U.S.), `+91 9876543210` (India)
   - **Format:** `+<Country Code> <Area Code> <Subscriber Number>`
   - **Masking Strategy:** Mask all but the last four digits. 
   - **Pattern Example (for masking):** `(\d{3})\d{4}(\d{4})` → `(\d{3})****(\d{4})`
   - **.properties Entry:**
     ```properties
     phone.number.type.mobile = mobile
     mobile.number.pattern = \+?\d{1,3}\s?\(?\d{1,4}\)?\s?\d{6,10}
     ```

### 2. **Landline Numbers**
   - **Description:** These are fixed-line numbers that are assigned to homes or offices.
   - **Pattern:** Landline numbers generally follow a fixed pattern depending on the area code.
   - **Example:** `+1 212-555-1234` (U.S.), `+91 22 28321567` (India)
   - **Format:** `+<Country Code> <Area Code> <Subscriber Number>`
   - **Masking Strategy:** Mask all but the last four digits of the subscriber number.
   - **Pattern Example (for masking):** `(\d{3})\d{4}(\d{4})` → `(\d{3})****(\d{4})`
   - **.properties Entry:**
     ```properties
     phone.number.type.landline = landline
     landline.number.pattern = \+?\d{1,3}\s?\(?\d{1,4}\)?\s?\d{7,10}
     ```

### 3. **Emergency Numbers**
   - **Description:** Short numbers dialed for emergency services (e.g., fire, police, ambulance).
   - **Pattern:** These are short numbers, typically between 3 to 4 digits.
   - **Example:** `911` (U.S.), `112` (EU), `999` (UK)
   - **Format:** No country code in many cases; simple digits.
   - **Masking Strategy:** Do **not** mask emergency numbers, as they must be visible for use.
   - **Pattern Example:** `\d{3,4}`
   - **.properties Entry:**
     ```properties
     phone.number.type.emergency = emergency
     emergency.numbers = 911,112,999,112
     emergency.number.pattern = \d{3,4}
     ```

### 4. **Toll-Free Numbers**
   - **Description:** Numbers that are free for the caller to dial (e.g., customer service).
   - **Pattern:** Typically start with specific prefixes like `800`, `888`, `877`, etc.
   - **Example:** `1-800-555-1234` (U.S.)
   - **Format:** `+<Country Code> <Toll-Free Prefix> <Subscriber Number>`
   - **Masking Strategy:** Mask the subscriber number except the last four digits.
   - **Pattern Example (for masking):** `(\d{3})\d{3}(\d{4})` → `(\d{3})***(\d{4})`
   - **.properties Entry:**
     ```properties
     phone.number.type.tollfree = tollfree
     tollfree.number.pattern = \+?\d{1,3}\s?(800|888|877)\s?\d{3}-\d{4}
     ```

### 5. **Premium Rate Numbers**
   - **Description:** Numbers that charge higher rates for calls, often used for specific services (e.g., voting, technical support).
   - **Pattern:** Usually start with prefixes like `900`, `976`, etc.
   - **Example:** `1-900-555-1234` (U.S.)
   - **Format:** `+<Country Code> <Premium Rate Prefix> <Subscriber Number>`
   - **Masking Strategy:** Mask the subscriber number except the last four digits.
   - **Pattern Example (for masking):** `(\d{3})\d{3}(\d{4})` → `(\d{3})***(\d{4})`
   - **.properties Entry:**
     ```properties
     phone.number.type.premiumrate = premiumrate
     premiumrate.number.pattern = \+?\d{1,3}\s?(900|976)\s?\d{3}-\d{4}
     ```

### 6. **Fax Numbers**
   - **Description:** Numbers assigned to fax machines.
   - **Pattern:** Similar to landline numbers but often used in specific business contexts.
   - **Example:** `+1 212-555-1234` (U.S.)
   - **Format:** `+<Country Code> <Area Code> <Subscriber Number>`
   - **Masking Strategy:** Mask the subscriber number except the last four digits.
   - **Pattern Example (for masking):** `(\d{3})\d{4}(\d{4})` → `(\d{3})****(\d{4})`
   - **.properties Entry:**
     ```properties
     phone.number.type.fax = fax
     fax.number.pattern = \+?\d{1,3}\s?\(?\d{1,4}\)?\s?\d{7,10}
     ```

### 7. **Virtual Numbers (VoIP)**
   - **Description:** Numbers assigned to virtual phones or VoIP services (e.g., Google Voice, Skype).
   - **Pattern:** These numbers often follow similar patterns to mobile numbers but are not tied to a physical phone line.
   - **Example:** `+1 800-555-1234` (U.S.)
   - **Format:** `+<Country Code> <Area Code> <Subscriber Number>`
   - **Masking Strategy:** Mask the subscriber number except the last four digits.
   - **Pattern Example (for masking):** `(\d{3})\d{4}(\d{4})` → `(\d{3})****(\d{4})`
   - **.properties Entry:**
     ```properties
     phone.number.type.virtual = virtual
     virtual.number.pattern = \+?\d{1,3}\s?\(?\d{1,4}\)?\s?\d{7,10}
     ```

### Example .properties File Structure

```properties
# Phone Number Types
phone.number.type.mobile = mobile
phone.number.type.landline = landline
phone.number.type.emergency = emergency
phone.number.type.tollfree = tollfree
phone.number.type.premiumrate = premiumrate
phone.number.type.fax = fax
phone.number.type.virtual = virtual

# Mobile Number Pattern (10 digit example)
mobile.number.pattern = \+?\d{1,3}\s?\(?\d{1,4}\)?\s?\d{6,10}

# Landline Number Pattern (U.S. example with area code)
landline.number.pattern = \+?\d{1,3}\s?\(?\d{1,4}\)?\s?\d{7,10}

# Emergency Number Pattern (short and always visible)
emergency.number.pattern = \d{3,4}

# Toll-Free Number Pattern (e.g., 800)
tollfree.number.pattern = \+?\d{1,3}\s?(800|888|877)\s?\d{3}-\d{4}

# Premium Rate Number Pattern (e.g., 900)
premiumrate.number.pattern = \+?\d{1,3}\s?(900|976)\s?\d{3}-\d{4}

# Fax Number Pattern (similar to landline)
fax.number.pattern = \+?\d{1,3}\s?\(?\d{1,4}\)?\s?\d{7,10}

# Virtual Number Pattern (similar to mobile)
virtual.number.pattern = \+?\d{1,3}\s?\(?\d{1,4}\)?\s?\d{7,10}

# Emergency Numbers that should not be masked
emergency.numbers = 911,112,999,112
```

### Conclusion

By stratifying phone numbers based on type, you provide clarity and specificity to developers when implementing masking and validation strategies. This will also help in applying different validation rules and masking logic depending on the type of number (e.g., emergency numbers should never be masked, while mobile or landline numbers should mask the digits except the last four).