package com.example.callapp;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;

public class CallReceiver extends PhonecallReceiver {

    DatabaseReference databaseReference;

    @Override
    protected void onIncomingCallReceived(final Context ctx, final String number, final Date start) {

        databaseReference = FirebaseDatabase.getInstance().getReference();

        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChild(number)){
                    User user = dataSnapshot.child(number).getValue(User.class);

                    if(user!=null) {
                        String firstName, lastName;
                        firstName = user.firstName;
                        lastName = user.lastName;

                        Toast.makeText(ctx, "CallApp is there, incoming call : "+number+" date : "+start, Toast.LENGTH_LONG).show();
                        final Intent intent = new Intent(ctx, CallReceivedActivity.class);
                        intent.putExtra("phoneNo", number);
                        intent.putExtra("firstName", firstName);
                        intent.putExtra("lastName", lastName);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        ctx.startActivity(intent);

                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        databaseReference.child("users").addListenerForSingleValueEvent(valueEventListener);


    }

    @Override
    protected void onIncomingCallAnswered(Context ctx, String number, Date start) {

    }

    @Override
    protected void onIncomingCallEnded(Context ctx, String number, Date start, Date end) {

    }

    @Override
    protected void onOutgoingCallStarted(Context ctx, String number, Date start) {

    }

    @Override
    protected void onOutgoingCallEnded(Context ctx, String number, Date start, Date end) {

    }

    @Override
    protected void onMissedCall(Context ctx, String number, Date start) {


    }
}
