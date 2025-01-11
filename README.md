# **masKit4j**
*A Java library for masking sensitive data in logs.*

---

## **Overview**

**masKit4j** is an Apache 2.0 licensed Java library designed to mask sensitive fields in logs across different data formats, including objects, JSON, and XML. It provides an easy-to-configure way to ensure sensitive information like phone numbers, email addresses, Aadhaar numbers, card details, and more are protected in log outputs. The library is flexible and supports custom masking strategies tailored to specific use cases.

---

## **Features**

- **Phone Number Masking**: Supports masking for mobile and landline numbers with optional configurations for country codes and masking ranges.
- **Email Address Masking**: Masks email addresses with customizable options for local parts, subdomains, and top-level domains.
- **Aadhaar Number Masking**: Easily mask Aadhaar numbers across your logs.
- **Card Details Masking**: Provides masking for card numbers, expiry dates, and CVV codes with configurable levels of detail.
- **Custom Masking Strategies**: Define and apply custom masking logic for specific fields or data structures.
- **Mask All Fields**: Option to mask all sensitive fields in a log while preserving certain characteristics like character length for debugging purposes.

---

## **Use Cases**

1. **Log Protection**: Prevent leakage of sensitive data in production logs.
2. **Compliance**: Meet data protection regulations like GDPR, PCI-DSS, or HIPAA by ensuring sensitive information is not visible in logs.
3. **Custom Masking Needs**: Address unique masking requirements for specific fields in your application.
4. **Debugging Support**: Configure different masking strategies for debug and production environments.

---

## **Masking Capabilities**

### **Phone Numbers**
- **Mobile Numbers**: Configure masking for mobile numbers, including optional handling of country codes and masking ranges for subscriber numbers.
- **Landline Numbers**: Mask local parts of landline numbers with optional support for country and STD codes.

### **Email Addresses**
- Mask local parts, subdomains, and top-level domains.
- Flexible masking ranges for the local part of email addresses.

### **Aadhaar Numbers**
- Quickly mask Aadhaar numbers for individuals or lists.

### **Card Details**
- **Card Numbers**: Mask middle digits while preserving the first and last few digits.
- **Expiry Dates**: Mask month, year, or both depending on the environment (e.g., debug vs. production).
- **CVV Codes**: Fully mask CVV codes, regardless of length.

### **Custom Masking**
- Define specific masking rules for fields with unique formats or requirements.
- Options to preserve the original character length for certain fields for debugging purposes.

---

## **Configuration**

masKit4j is highly configurable through properties files or Java-based configuration. Key configurations include:

1. **Field Definitions**: Specify the fields to be masked for each data type (e.g., phone numbers, emails, Aadhaar, cards).
2. **Masking Ranges**: Define which portions of a field should be masked (e.g., mask from the 2nd to the 7th character).
3. **Environment-Specific Masking**: Apply different masking levels based on the environment (e.g., debug vs. production).
4. **Custom Field Masking**: Use custom strategies for non-standard fields or formats.

---

## **Best Practices**

- **Minimal Exposure**: Configure masking to reveal only the necessary portions of sensitive fields for debugging.
- **Environment Awareness**: Use stricter masking in production logs while enabling controlled exposure for debugging purposes.
- **Compliance Assurance**: Regularly review your configuration to ensure compliance with the latest data protection regulations.
- **Field Naming Consistency**: Use consistent field names across your codebase to simplify masking configurations.

---

## **Getting Started**

1. **Add Dependency**: Include masKit4j in your project using Maven, Gradle, or any other dependency management tool.
2. **Configure Masking**: Define your masking configuration in the properties file or using Java-based configuration.
3. **Apply Masking**: Integrate masKit4j into your logging framework to automatically mask sensitive fields.

---

## **Support**

If you encounter issues or have feature requests, feel free to open an issue on the [GitHub repository](#).

---

## **License**

**masKit4j** is licensed under the [Apache 2.0 License](https://www.apache.org/licenses/LICENSE-2.0).