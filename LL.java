class LL {
    public Node head;
class Node
{
    int value;
    Node next;
    Node(int value)
    {
       this.value = value;
       this.next=null;
    }
} 
     public LL()
     {
        head=null;
     } 

//inserting at beginning of list.
  public void insertAtBeginning(int value)
  {
    Node newNode = new Node(value);
       newNode.next=head;
       head=newNode;
  }
//insert at End
  public void insertAtEnd(int value)
  {
      Node newNode = new Node(value);
        if(head==null)
        {
         head=newNode;
        }
        else
        {
         Node current=head;
         while(current.next!=null)
         {
             current=current.next;

         }
           current.next=newNode;
        
      }

  }
  //insertion at any index
  public void insertAtIndex(int value, int index)
  {
     if(index<0)
     {
      throw new IllegalArgumentException("Index should be non-negative");
     }
  
     
      Node newNode = new Node(value);
      if(index==0)
      {
         newNode.next=head;
         head=newNode;
      }else
      {
         Node current=head;
         int currentIndex = 0;
         while(current!=null && currentIndex < index-1)
         {
              current=current.next;
              currentIndex++;
         }
      
         if(current==null)
        {
               throw new IndexOutOfBoundsException("Index out of bounds");
        }
           newNode.next=current;
           current=current.next;     
        
      }

   }


  public void display()
  {
     Node current=head;
     while(current!=null)
     {
        System.out.print(current.value+"--> ");
        current=current.next;
     }
        System.out.println("null");
  }
 
 public static void main(String[] args)
 {
    LL list = new LL();
    list.insertAtBeginning(3);
    list.insertAtBeginning(2);
    list.insertAtBeginning(1);
    list.insertAtEnd(9);
    
       list.display();
       list.insertAtIndex(5, 1);
       list.display();
 }   
}
