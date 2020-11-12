from django.urls import path
from .views import DoctorAPIView, DietPlanAPIView, ExercisePlanView, MedicineView, PatientView

urlpatterns = [
    # path('doctor', DoctorAPIView.as_view()),
    path('doctor/<int:id>', DoctorAPIView.as_view()),
    path('dietplan/<int:id>', DietPlanAPIView.as_view()),
    path('exerciseplan/<int:id>', ExercisePlanView.as_view()),
    path('medicine/<int:id>', MedicineView.as_view()),
    path('patient/<int:id>', PatientView.as_view()),

]