from django.shortcuts import render
from django.http import HttpResponse
from rest_framework import serializers
from .models import Doctor, DietPlan, ExercisePlan, Medicine, Patient
from .serializers import DietPlanSerializer, DoctorSerializer, ExercisePlanSerializer, MedicineSerializer, PatientSerializer
from rest_framework.response import Response
from rest_framework import status
from rest_framework.views import APIView
# Create your views here.

class DoctorAPIView(APIView):
    def get(self, request, id):
        doctors = Doctor.objects.all().order_by('doctor_id')
        serializer = DoctorSerializer(doctors, many= True)
        return Response(serializer.data)

    def post(self, request, id):
        serializer = DoctorSerializer(data=request.data)

        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status= status.HTTP_201_CREATED)
        return Response(serializer.errors, status= status.HTTP_400_BAD_REQUEST)

    def put(self, request, id):
        try:
            doctor = Doctor.objects.get(pk = request.data['doctor_id'])
        except Doctor.DoesNotExist:
            return HttpResponse(status= status.HTTP_404_NOT_FOUND)
        serializer = DoctorSerializer(doctor, data= request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    def delete(self, request, id):
        try:
            doctor = Doctor.objects.get(pk = id)
        except Doctor.DoesNotExist:
            return HttpResponse(status= status.HTTP_404_NOT_FOUND)
        doctor.delete()
        return Response(status = status.HTTP_204_NO_CONTENT)

    
class DietPlanAPIView(APIView):
    def get(self, request, id):
        diet_plan = DietPlan.objects.all().order_by('diet_id')
        serializer = DietPlanSerializer(diet_plan, many= True)
        return Response(serializer.data)

    def post(self, request, id):
        serializer = DietPlanSerializer(data=request.data)

        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status= status.HTTP_201_CREATED)
        return Response(serializer.errors, status= status.HTTP_400_BAD_REQUEST)

    def put(self, request, id):
        try:
            diet_plan = DietPlan.objects.get(pk = request.data['diet_id'])
        except DietPlan.DoesNotExist:
            return Response(status= status.HTTP_404_NOT_FOUND)
        serializer = DietPlanSerializer(diet_plan, data= request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    def delete(self, request, id):
        try:
            diet_plan = DietPlan.objects.get(pk = id)
        except DietPlan.DoesNotExist:
            return HttpResponse(status= status.HTTP_404_NOT_FOUND)
        diet_plan.delete()
        return Response(status = status.HTTP_204_NO_CONTENT)

class ExercisePlanView(APIView):
    def get(self, request, id):
        exercise_plan = ExercisePlan.objects.all().order_by('exercise_id')
        serializer = ExercisePlanSerializer(exercise_plan, many= True)
        return Response(serializer.data)

    def post(self, request, id):
        serializer = ExercisePlanSerializer(data=request.data)

        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status= status.HTTP_201_CREATED)
        return Response(serializer.errors, status= status.HTTP_400_BAD_REQUEST)

    def put(self, request, id):
        try:
            exercise_plan = ExercisePlan.objects.get(pk = request.data['exercise_id'])
        except ExercisePlan.DoesNotExist:
            return Response(status= status.HTTP_404_NOT_FOUND)
        serializer = ExercisePlanSerializer(exercise_plan, data= request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    def delete(self, request, id):
        try:
            exercise_plan = ExercisePlan.objects.get(pk = id)
        except ExercisePlan.DoesNotExist:
            return Response(status= status.HTTP_404_NOT_FOUND)
        exercise_plan.delete()
        return Response(status = status.HTTP_204_NO_CONTENT)

class MedicineView(APIView):
    def get(self, request, id):
        medicine = Medicine.objects.all().order_by('medicine_id')
        serializer = MedicineSerializer(medicine, many = True)
        return Response(serializer.data)
    
    def post(self, request, id):
        serializer = MedicineSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status= status.HTTP_201_CREATED)
        return Response(serializer.errors, status = status.HTTP_400_BAD_REQUEST)
    
    def put(self, request, id):
        try:
            medicine = Medicine.objects.get(pk= request.data['medicine_id'])
        except:
            return Response(status = status.HTTP_404_NOT_FOUND)
        serializer = MedicineSerializer(medicine, data = request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    def delete(self, request, id):
        try:
            medicine = Medicine.objects.get(pk = id)
        except Medicine.DoesNotExist:
            return Response(status= status.HTTP_404_NOT_FOUND)
        medicine.delete()
        return Response(status = status.HTTP_204_NO_CONTENT)

class PatientView(APIView):
    def get(self, request, id):
        patient = Patient.objects.all().order_by('patient_id')
        serializer = PatientSerializer(patient, many = True)
        return Response(serializer.data)
    
    def post(self, request, id):
        serializer = PatientSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status= status.HTTP_201_CREATED)
        return Response(serializer.errors, status = status.HTTP_400_BAD_REQUEST)
    
    def put(self, request, id):
        try:
            patient = Patient.objects.get(pk= request.data['patient_id'])
        except:
            return Response(status = status.HTTP_404_NOT_FOUND)
        serializer = PatientSerializer(patient, data = request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    def delete(self, request, id):
        try:
            patient = Patient.objects.get(pk = id)
        except Patient.DoesNotExist:
            return Response(status= status.HTTP_404_NOT_FOUND)
        patient.delete()
        return Response(status = status.HTTP_204_NO_CONTENT)