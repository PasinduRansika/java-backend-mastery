package GymBuddy.Service;


import GymBuddy.Model.SchedulePreference;
import GymBuddy.Model.Specialization;
import GymBuddy.Model.Trainer;

import java.util.*;
import java.util.stream.*;
import java.util.concurrent.ConcurrentHashMap;

public class TrainerService{
    private Map<Integer, Trainer> trainerList = new ConcurrentHashMap<>();

    public Collection<Trainer> getAllTrainers() {
        return Collections.unmodifiableCollection(trainerList.values());
    }

    public void registerTrainer(Trainer trainer){
        if(trainerList.containsKey(trainer.getTrainerID())){
            throw new IllegalArgumentException("Trainer ID Already Exits !");
        }
        trainerList.put(trainer.getTrainerID(),trainer);

    }

    public Trainer findTrainerById(int id){
        return Optional.ofNullable(trainerList.get(id)).orElseThrow(() -> new NoSuchElementException("Could Not Found !"));
    }

    public void removeTrainer(int id){
        if(!trainerList.containsKey(id)){
            throw new GymBuddy.Exception.NoSuchElementException("No Trainer Found");
        }
        trainerList.remove(id);
    }

    public List<Trainer> getBySpecialization(Specialization specialization) {
        return trainerList.values().stream()
                .filter(t -> t.getSpecialization() == specialization)
                .toList();
    }

    public void updateSpecialization(int trainerId, Specialization specialization){
        findTrainerById(trainerId).setSpecialization(specialization);
    }

    public void updatePreference(int trainerId, SchedulePreference pref) {
        findTrainerById(trainerId).setSchedulePreference(pref);
    }

}
