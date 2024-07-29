# EcoApp

Overview : 

Eco App is an Android application that displays a carousel of items with images and details. Users can search through these items and view detailed statistics about the content.

Features :

Carousel Display: Showcases a list of items in a carousel view with images and details.
Search Functionality: Allows users to search for items by name or other criteria.
Detailed Statistics: Provides insights into the items, such as the number of items per category and the most common characters in titles.
Responsive UI: Utilises ViewPager2 for smooth navigation and a BottomSheetDialogFragment for displaying statistics.

Usage :

Viewing the Carousel: Swipe left or right to navigate through the items in the carousel.
Searching: Use the search bar at the top to filter items based on your input.
Viewing Statistics: Click on the floating action button (FAB) to view statistics about the items displayed.

Architecture :

The app follows the MVVM (Model-View-ViewModel) architecture pattern, ensuring a clear separation of concerns and making the codebase more maintainable.

ViewModel: Manages the UI-related data and handles the business logic of the app.
Repository: Provides data to the ViewModel, either from a local source (mock data) or a remote source.
StateFlow: Observes changes in data and updates the UI accordingly.


Screenshots :
(Include screenshots to visually demonstrate the app's features.)

![Screenshot_1723547923](https://github.com/user-attachments/assets/091aba7f-eeb1-4486-9b76-0b2f51a52353)

![Screenshot_1723547942](https://github.com/user-attachments/assets/60f176da-c7d9-4f00-b1c1-1468b2fec51a)

![Screenshot_1723547955](https://github.com/user-attachments/assets/1241973b-baab-4529-8fbc-71a4283691ee)

![Screenshot_1723547967](https://github.com/user-attachments/assets/32e167a4-e973-4d2c-b64a-7183eb5af74b)





