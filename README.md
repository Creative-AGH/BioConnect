# BioConnect Application
> - The project was created in 24 hours on the HackYeah2022 competition in Tauron Arena Kraków. We had been working 24 hours 
on a specific challenge - Let's compost IT task - and trying to solve it in the most effective way.
> - We have decided to address the problem of ignoring and lack of reusability of biodegradable waste

![](https://i.imgur.com/6aqP4Il.jpg)
## Issues:
> - Low public awareness
> - Insufficient amount of information about composting biowaste in municipalities resulting in high fines for municipalities
> - Waste biowaste

## Idea/Solution:
> - Creating a platform for collaboration and finding nearby storage or collection points for bio waste
> - Public education
> - Replacing paper surveys with digital declarations

## Used technologies:
- Java 17
- Spring 2.7
- MySQL (production profile)
- H2 Database (development profile)
- Swagger and Swagger-UI (documentation)
- Spring Data JPA
- MapStruct
- Spring Security (login with JWT token)
- Lombok
- ThyMeLeaf (register confirmation email)
- Java Mail Api (sending emails)
- Dockerfile
- Docker
- Nginix (reverse proxy)
- Apache POI (for generating excel reports)

## About:
The "BioConnect" application is an app that connects farmers and individuals willing to produce bio-fertilizer from compost. The app was created primarily to solve the problem of insufficient information about composting waste by citizens in specific municipalities, which results in high fines for these municipalities. Our app also addresses two other problems, namely, low public awareness about creating compost bins from appropriate biodegradable waste, and wasting waste that could be used as fertilizer for agricultural crops. This is where we come in as a team of developers who have worked together to create an online collaboration platform at HackYeah 2022, replacing data collection through surveys that result in inadequate quantity, quality, and reliability of information about appropriate biowaste for composting.

Users - citizens of a specific municipality, for example - can register in the created application and report their compost bin through an interactive map. Users can register the amount of accumulated waste, to which the municipality can have access to, and can easily access the history of waste disposed of by users in a specific area, for example, a municipality, and obtain the total amount of waste disposed of in a specific time period, such as specific days, months, or years. In addition to regular compost bins, users can also report their current compost status (based on user input and confirmed by the owner of the compost bin). If there is a lot of compost inside the bin, other residents/farmers (or the owner) can come and pick up the produced compost from a specific location.

The application also includes the generation of Excel reports in a very convenient way for the person who has appropriate permissions in the application, such as an administrator or official. Our application was designed with a generic mode in mind, i.e. extensible in an easy and universal way. In this case, we also support the possibility of reporting other relevant bio-wastes that can be useful, such as grass (which can be used as feed for animals), ash from bio materials (which can be used as a soil fertilizer or for leveling the ground), branches, wood, sawdust, which can be used to produce pellets, a fuel material. More possibilities can be easily added with minimal effort (here, only our creativity limits us ;)).

The application also includes an educational component, such as which waste is suitable for a composter and which is not. Of course, the educational part could not lack interesting facts on this topic, including that hair, fur, and beer are also suitable for a composter. The visual part of the website was prepared by a group of three people who professionally designed the application interface, which means that each person using our system will be able to use it in a very simple and intuitive way.

The application operates in a containerized environment based on the Docker engine and the Docker-Compose extension. The application has been divided into two parts: the backend (application logic) and frontend (user interface). Both parts have been placed on a reverse proxy using the NGINX service. Such an architecture guarantees horizontal scalability as the load increases and increases the security of the application compared to the standard approach.

#### The Backend part has been created using Java 17 along with the Spring framework
Inside it, there are <b>features</b> such as:

> - User security and verification based on a JWT token
> - Connection to a MYSQL database using Spring Data JPA
> - Sending activation emails in HTML format
> - Generating Excel reports in 2 modes
> - A summary of the amount of waste for each user in a given month, creating a report ready for use
> - For a single user, indicating how much and when they disposed of waste
> - A list of waste types and other related items
> - An exchange market and payment processor for the exchange and redemption of compost (or giving compost away for free in 2 modes)
> - Application log logging to files depending on the profile.
## Current project authors are:
### Server Side - backend:
- Adam Wasylewicz - https://www.linkedin.com/in/adam-wasylewicz-57a990238/
- Patryk Janas - https://www.linkedin.com/in/patrykjanas27/
### Client Side - frontend and UI/UX:
- Przemysław Matraj - https://www.linkedin.com/in/przemyslawmatraj/
- Lidia Moryc - https://www.linkedin.com/in/lidia-moryc-7635b2263/
- Mateusz Majka - https://www.linkedin.com/in/mateusz-majka-473919196/
### DevOps:
- Mariusz Wermiński - https://www.linkedin.com/in/mwerminski/

![](https://i.imgur.com/VviOmoZ.jpg)
## Application Design UI/UX: 

![](https://i.imgur.com/LYeXudr.jpg)

![](https://i.imgur.com/BwNAcNV.jpg)

![](https://i.imgur.com/gZEk1Qn.jpg)



