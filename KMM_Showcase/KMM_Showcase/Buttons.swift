//
//  Buttons.swift
//  KMM_Showcase
//
//  Created by Edgars Simanovskis on 22/3/2565 BE.
//  Copyright © 2565 BE orgName. All rights reserved.
//

import SwiftUI

struct BackButton: View {
    @Environment(\.presentationMode) var presentationMode: Binding<PresentationMode>
    var text: String
    
    var body: some View {
        Button(action: {
            self.presentationMode.wrappedValue.dismiss()
        }) {
            HStack(spacing: 20) {
                Image("ic_back")
                    .resizable()
                    .frame(width: 20, height: 20)
                Text(text)
                    .foregroundColor(.blackColor)
                    .fontWeight(.bold)
                    .font(.title3)
                Spacer()
                
            }
//            .padding()
            .frame(maxWidth: .infinity)
//            .background(Color.white)
        }
    }
}

struct FatGreenButton: ButtonStyle {
    func makeBody(configuration: Configuration) -> some View {
        configuration.label
            .frame(maxWidth: .infinity)
            .font(.title2)
            .foregroundColor(.white)
            .padding()
            .background(Color.greenColor)
            .clipShape(RoundedRectangle(cornerRadius: 20))
    }
}
