//
//  NavBar.swift
//  iosApp
//
//  Created by Edgars Simanovskis on 24/3/2565 BE.
//  Copyright © 2565 BE orgName. All rights reserved.
//

import SwiftUI

struct NavBar: View {
    @Environment(\.presentationMode) var presentationMode: Binding<PresentationMode>
    var title: String
    
    var body: some View {
        HStack(spacing: 20) {
            Button(action: {
                self.presentationMode.wrappedValue.dismiss()
            }) {
                Image("ic_back")
                    .resizable()
                    .frame(width: 20, height: 20)
            }
            Text(title)
                .foregroundColor(.blackColor)
                .fontWeight(.bold)
                .font(.title3)
            Spacer()
            
        }
        .frame(maxWidth: .infinity)
        .padding(.leading)
        .padding(.top, UIApplication.shared.windows.first?.safeAreaInsets.top)
    }
}
