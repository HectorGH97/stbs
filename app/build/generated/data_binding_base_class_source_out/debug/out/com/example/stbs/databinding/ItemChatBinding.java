// Generated by view binder compiler. Do not edit!
package com.example.stbs.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.example.stbs.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemChatBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView chatNameText;

  @NonNull
  public final TextView usersTextView;

  private ItemChatBinding(@NonNull ConstraintLayout rootView, @NonNull TextView chatNameText,
      @NonNull TextView usersTextView) {
    this.rootView = rootView;
    this.chatNameText = chatNameText;
    this.usersTextView = usersTextView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemChatBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemChatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_chat, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemChatBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.chatNameText;
      TextView chatNameText = rootView.findViewById(id);
      if (chatNameText == null) {
        break missingId;
      }

      id = R.id.usersTextView;
      TextView usersTextView = rootView.findViewById(id);
      if (usersTextView == null) {
        break missingId;
      }

      return new ItemChatBinding((ConstraintLayout) rootView, chatNameText, usersTextView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}