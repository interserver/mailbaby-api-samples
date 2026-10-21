#See https://aka.ms/containerfastmode to understand how Visual Studio uses this Dockerfile to build your images for faster debugging.

# Container we use for final publish
FROM mcr.microsoft.com/dotnet/aspnet:10.0 AS base
WORKDIR /app
EXPOSE 80
EXPOSE 443

# Build container
FROM mcr.microsoft.com/dotnet/sdk:10.0 AS build

# Copy the code into the container
WORKDIR /src
COPY ["src/MailBabyAspnetcore/MailBabyAspnetcore.csproj", "MailBabyAspnetcore/"]

# NuGet restore
RUN dotnet restore "MailBabyAspnetcore/MailBabyAspnetcore.csproj"
COPY ["src/MailBabyAspnetcore/", "MailBabyAspnetcore/"]

# Build the API
WORKDIR "MailBabyAspnetcore"
RUN dotnet build "MailBabyAspnetcore.csproj" -c Release -o /app/build

# Publish it
FROM build AS publish
RUN dotnet publish "MailBabyAspnetcore.csproj" -c Release -o /app/publish

# Make the final image for publishing
FROM base AS final
WORKDIR /app
COPY --from=publish /app/publish .
ENTRYPOINT ["dotnet", "MailBabyAspnetcore.dll"]
