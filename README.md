# Viderity
## General Project Details
∙ Implemented the Google Vision API (FireBase ML Kit) to extract text from an image (either from gallery or camera).
∙ Utilized Android Studio's text-to-speech feature to read the extracted text aloud.
## API Choice Considerations
∙ When looking for an API, it was important for the API to have documentation for Java developers. 
∙ Although I'd used OpenCV for image processing in the past (and considered Tesseract briefly), they weren't as supported for the Java language than they are for Python.
## Choice of Functionality / Product Inspiration
∙ The inspiration of Viderity came from me wanting to try out Google's Vision API.
∙ Going forward from this, I thought it would be interesting to make a product that makes it easier for blind students to learn.
∙ Trying out Android Studio for a bit, it became clear that the built-in text-to-speech capability would make an excellent addition to Viderity.
## Technical Challenges
∙ When loading images into the VM gallery, it was important to have images be loaded in a Bitmap format rather than PNG, VEC, etc.
∙ When other image formats were tried, the Vision API didn't recognize text as accurately. In fact, in some cases the Vision API didn't recognize text was in some frame at all.
∙ The text-to-speech functionality in Android is very limited.
  ∙ It is not good with reading text that spans multiple lines.
  ∙ It is not good with reading text in a way that humans would read natural language.
## Future Technical Improvements
∙ Implementing voice commands so that a user can execute in-app commands with voice instead of interacting with our interface. 
∙ Added functionality so that text-to-speech feature can read the text that takes into account how natural language is read by human beings.
