public class Demo {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.enqueue(78,56,"Saman","Moratuwa");
        pq.enqueue(9,56,"Kamal","Moratuwa");
        pq.enqueue(12,56,"Aruni","Moratuwa");
        pq.enqueue(4,56,"Jagath","Moratuwa");
        pq.enqueue(8,56,"Waruna","Moratuwa");
        pq.display();
        try{
            pq.dequeue();
            pq.display();
            System.out.println(pq.peek());
        }catch (Exception e){
            System.out.println(e);
        }

    }

}
class Patient {
    int patientNo;
    int age;
    String patientName;
    String address;
    Patient next;

    public Patient(int patientNo, int age, String patientName, String addrss) {
        this.patientNo = patientNo;
        this.patientName = patientName;
        this.age = age;
        this.address = addrss;
    }
}

class PriorityQueue {
    private Patient head;
    private Patient tail;

    public void enqueue(int patientNo, int age, String patientName, String address) {
        //add the patient to the relevant place of the queue
        Patient newp = new Patient(patientNo, age, patientName, address);
        Patient current = head;
        Patient previous = head;

        if(current==null){
            head = newp;
            tail = newp;
            return;
        }

        while (current != null) {
            if (patientNo < current.patientNo) {

                if(current==head){
                    newp.next=head;
                    head=newp;
                    tail=head;
                    return;
                }

                previous.next = newp;
                newp.next = current;
                return;
            }
            previous = current;
            current = current.next;

            if(current==null){
                previous.next = newp;
                tail=newp;
                return;
            }
        }


    }

    public String dequeue() throws Exception {
        //remove the front patient and return the name of the patient
        if(head==null){
            throw new Exception("Queue is empty cannot dequeue");
        }
        String pName = head.patientName;
        head = head.next;
        if(head==null){
            tail = null;
        }
        return pName;
    }

    public String peek() throws Exception {
        //return the name of the front patient
        if(head==null){
            throw new Exception("Queue is empty");
        }
        return head.patientName;
    }

    public void display() {
        //display all the patient names in the queue
        Patient current = head;
        while (current!=null){
            System.out.print(current.patientName+" ");
            current = current.next;
        }

        System.out.println();
    }
}