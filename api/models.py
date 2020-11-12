from django.db import models

# Create your models here.
class Doctor(models.Model):
    doctor_id = models.AutoField(primary_key=True)
    name = models.CharField(max_length=20)
    category = models.CharField(max_length= 30)
    phone_no = models.CharField(max_length= 12)
    email = models.EmailField(max_length=30)
    def __str__(self):
        return self.doctor_id

class DietPlan(models.Model):
    diet_id = models.AutoField(primary_key = True)
    diet_name = models.CharField(max_length=100)
    calories = models.IntegerField(blank= True, null=True)
    def __str__(self):
        return self.diet_id

class ExercisePlan(models.Model):
    exercise_id = models.AutoField(primary_key = True)
    exercise_name = models.CharField(max_length=30)
    days = models.IntegerField(blank=True, null= True)
    def __str__(self):
        return self.exercise_id


class Medicine(models.Model):
    medicine_id = models.AutoField(primary_key = True)
    name = models.CharField(max_length =30)
    dosage = models.IntegerField(blank=True, null= True)
    days  = models.IntegerField(blank = True, null= True)
    def __str__(self):
        return self.medicine_id

class Patient(models.Model):
    patient_id = models.AutoField(primary_key = True)
    first_name = models.CharField(max_length= 200)
    last_name = models.CharField(max_length=20, blank=True)
    address = models.TextField(max_length= 100)
    date_of_birth = models.DateField()
    ailment = models.TextField(max_length=200, blank= True)
    diet = models.ForeignKey(DietPlan, models.SET_NULL, blank=True, null=True)
    exercise = models.ForeignKey(ExercisePlan, models.SET_NULL, blank = True, null = True)
    medicine = models.ForeignKey(Medicine, models.SET_NULL, blank = True, null = True)
    def __str__(self):
        return self.patient_id




