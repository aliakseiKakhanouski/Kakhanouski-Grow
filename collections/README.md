# Java Collections

#### Task

Write a programm that calculates and prints count of each word which appears in a text.

#### Task Details

- Every input parameter goes from command line argument
- Input text must be read from a text-file (*mandatory parameter*)
- Direction of output result: from the smallest count of found words to the greatest (*non-mandatory parameter*)
- If count is the same, then alphabetical comparison of words
- If direction is not set, then order doesn't matter

# Testing

#### Task

Write unit tests using JUnit + Mockito/EasyMock.

#### Task Details

- Refactor existing utility classes: let's make them plain classes without static methods.
- Map 'service' class must contain intance of a File 'service' class.
- Map 'service' class must do the same: take name of a file, delegate data reading to File 'service', proceed data, return resutl.
