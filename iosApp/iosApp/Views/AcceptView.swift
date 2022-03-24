//
//  AcceptView.swift
//  iosApp
//
//  Created by Edgars Simanovskis on 24/3/2565 BE.
//  Copyright © 2565 BE orgName. All rights reserved.
//

import SwiftUI

struct AcceptView: View {
    var description = "Get this job to know more about farmer contact information"
    var price = "80-95 Baht"
    var body: some View {
        VStack(alignment: .leading) {
            Text(description)
                .fontWeight(.semibold)
                .padding(.vertical)
            HStack {
                Text("Price")
                    .fontWeight(.light)
                Spacer()
                Text(price)
                    .font(.title3)
                    .fontWeight(.bold)
                    .foregroundColor(.greenColor)
            }
            Button("Accept", action: {})
                .buttonStyle(FatGreenButton())
                .padding(.bottom, 30)
        }
        .padding()
        .background(Color.white)
        .cornerRadius(40)
        .overlay(
            RoundedRectangle(cornerRadius: 40)
                .stroke(Color.gray.opacity(0.2), lineWidth: 1)
        )
        .offset(y: 20)
    }
}
