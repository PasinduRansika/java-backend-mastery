package GymBuddy.Service;

import GymBuddy.Exception.NoSuchElementException;
import GymBuddy.Model.Member;
import GymBuddy.Model.SchedulePreference;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class MemberService {
    private Map<Integer,Member> memberList = new ConcurrentHashMap<>();

    public Collection<Member> getAllMembers() {
        return Collections.unmodifiableCollection(memberList.values());
    }

    public void registerMember(Member member){
        if(memberList.containsKey(member.getMemberId())){
            throw new IllegalArgumentException("Member ID Already Exits !");
        }
        memberList.put(member.getMemberId(), member);
    }

    public Member findMemberById(int id){
        return Optional.ofNullable(memberList.get(id)).orElseThrow(() -> new NoSuchElementException("Could Not Found !"));
    }

    public void updateLocation(int memberId, String location) {
        findMemberById(memberId).setLocation(location);
    }

    public void updatePreference(int memberId, SchedulePreference pref) {
        findMemberById(memberId).setSchedulePreference(pref);
    }

    public void removeMember(int memberId){
        if(!memberList.containsKey(memberId)){
            throw new NoSuchElementException("No Member Found !");
        }
        memberList.remove(memberId);

    }

    public double getWeightDifference(int memberId){
        Member member = findMemberById(memberId);
        var log = member.getWeightLog();
        if (log.isEmpty()) return 0.0;

        double initialWeight = log.getFirst().getWeight();
        double currentWeight = log.getLast().getWeight();

        return currentWeight - initialWeight;
    }


}
