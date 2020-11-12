from rest_framework import serializers
from .models import Doctor, DietPlan, ExercisePlan, Medicine, Patient

class DoctorSerializer(serializers.ModelSerializer):
    class Meta:
        model = Doctor
        fields = '__all__'

class DietPlanSerializer(serializers.ModelSerializer):
    class Meta:
        model = DietPlan
        fields = '__all__'
 
class ExercisePlanSerializer(serializers.ModelSerializer):
    class Meta:
        model = ExercisePlan
        fields = '__all__'
 
class MedicineSerializer(serializers.ModelSerializer):
    class Meta:
        model = Medicine
        fields = '__all__'

class PatientSerializer(serializers.ModelSerializer):
    class Meta:
        model = Patient
        fields = '__all__'
 
 