# Zibcha Stocks App

## Overview

Zibcha Stocks App is an Android application built using Clean Architecture and MVVM principles. It provides stock and contact management features along with data export functionality in multiple formats such as CSV, JSON, and PDF.

The project is designed with scalability, modularity, and maintainability in mind by following a feature-based package structure and proper separation of concerns.

---

## Architecture

The application follows Clean Architecture with three main layers:

### Presentation Layer

Responsible for UI and user interaction.

* Fragments for UI screens
* ViewModels for state management
* RecyclerView adapters for list rendering

### Domain Layer

Contains business logic and is independent of Android frameworks.

* Use cases for specific actions
* Repository interfaces
* Pure Kotlin models

### Data Layer

Handles data sources and implementation details.

* Feature-based structure (stocks, contacts)
* Remote data sources (API services)
* Repository implementations
* DTO to domain mapping

---

## Project Structure

```
data/
  stocks/
  contacts/
  core/
  export/

domain/
  stocks/
  contacts/
  export/

presentation/
  stocks/
  contacts/
  main/

di/
  modules for dependency injection
```

---

## Dependency Injection

The project uses Hilt for dependency injection.

Modules are separated by feature:

* StockModule
* ContactModule
* ExportModule

This ensures proper dependency management and scalability.

---

## Multibinding Implementation

The app uses Hilt Map Multibinding for handling multiple exporters.

### Exporters

* CsvExporter
* JsonExporter
* PdfExporter

Each exporter implements a common `Exporter` interface.

They are injected as:

```
Map<ExportType, Exporter>
```

### Usage

The `ExportDataUseCase` selects the appropriate exporter at runtime based on the selected export type.

### Benefits

* Eliminates conditional logic
* Easily extendable for new formats
* Follows Open/Closed Principle

---

## Features

* Display stock data
* Display contact data
* Export data to CSV, JSON, and PDF
* Modular and scalable architecture

---

## Tech Stack

* Kotlin
* Android SDK
* MVVM Architecture
* Clean Architecture
* Hilt Dependency Injection
* RecyclerView
* ViewBinding

---

## Future Improvements

* Add Room database for local caching
* Implement offline-first strategy
* Add unit and UI testing
* Improve error handling and UI states
* Add pagination and performance optimizations

---

## Conclusion

This project demonstrates a well-structured Android application using Clean Architecture and modern development practices. The use of feature-based modularization and multibinding makes the application scalable and easy to extend.
