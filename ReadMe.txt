🚀 Project Overview

The Resident Management System (RMS) centralises all resident-related information, care interactions, and documentation into one unified platform.
It reduces paperwork, increases accuracy, provides accountability through audit logs, and enhances day-to-day workflow for care staff and administrators.

🎯 Project Goals

Create a secure and scalable system for managing residents in a care home.

Digitise support plans, interactions, and emergency contacts.

Provide staff with an intuitive interface to record and retrieve resident information.

Ensure GDPR-compliant data storage and access control.

Deploy a professionally structured full-stack application accessible online.

🧩 Core Features (MVP)
Residents Management

Create, update, view, and delete resident profiles

Emergency contact management

Support plan creation and editing

Daily care interaction logging

Search and filter resident records

Authentication

JWT-based login

Admin + Staff roles

Secure password hashing (bcrypt)

Data Export

CSV export for resident lists and interactions

Audit Logging

Tracks create/update/delete actions

Stores user, timestamp, and action type

Responsive UI

Mobile-friendly

Tailwind CSS styling

🏗 System Architecture
Frontend

React (Vite)

Tailwind CSS

React Router

Axios

Backend

Spring Boot 3

Spring Security (JWT)

PostgreSQL

MapStruct / Lombok

JPA + Hibernate

Infrastructure

Backend Hosting: Render

Frontend Hosting: Vercel

Database: PostgreSQL

CI/CD: GitHub Actions

📁 Domain Model
Core Entities

User (Admin/Staff)

Resident

Contact

SupportPlan

CareInteraction

AuditLog

Relationships
Entity	Relationship
Resident → Contacts	One-to-Many
Resident → Support Plans	One-to-Many
Resident → Care Interactions	One-to-Many
🔌 API Endpoints (MVP)
Auth

POST /api/v1/auth/login

POST /api/v1/auth/register

Residents

GET /api/v1/residents

POST /api/v1/residents

PUT /api/v1/residents/{id}

DELETE /api/v1/residents/{id}

Contacts

GET /api/v1/residents/{id}/contacts

POST /api/v1/residents/{id}/contacts

Support Plans

POST /api/v1/residents/{id}/support-plans

PUT /api/v1/support-plans/{id}

Care Interactions

POST /api/v1/residents/{id}/interactions

Data Export

GET /api/v1/residents/export?format=csv

🖥️ Frontend Pages

Login

Dashboard

Residents List

Resident Profile

Support Plan Editor

Interaction Entry

User Management

CSV Export page

🔐 Security & Privacy

HTTPS enforced in production

JWT Authentication

Role-based access control (Admin/Staff)

Bcrypt password hashing

Input validation + sanitisation

Environment variables for secrets

GDPR compliance

Data minimisation

Export/delete endpoints

Logging of access

📦 Deployment Configuration
Backend – Render
Build Command: mvn clean package
Start Command: java -jar target/rms-backend.jar


Required Environment Variables

SPRING_PROFILES_ACTIVE=prod
DATABASE_URL=postgres://...
JWT_SECRET=your-secret-key
FRONTEND_URL=https://your-vercel-app.vercel.app

Frontend – Vercel
npm install
npm run build


Environment Variables

VITE_API_BASE_URL=https://your-render-backend.onrender.com

🔄 Project Workflow (Backlog)
Sprint 1

Repo setup

Project skeleton (backend + frontend)

Resident CRUD

Sprint 2

Contacts module

Daily interactions module

Sprint 3

Support plans

CSV export

Dashboard

Sprint 4

Testing

Deployment to Render + Vercel

📈 Success Criteria

Fully deployed and accessible system

Staff use it for resident management

Reduced paperwork and manual errors

Positive feedback from care home pilot

Stable under real usage

🛠️ Future Enhancements

Medication management

Finance tracking

Reporting dashboards

Document uploads

Multi-home support

Pharmacy + GP integration