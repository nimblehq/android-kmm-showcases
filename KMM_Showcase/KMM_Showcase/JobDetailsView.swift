//
//  JobDetailsView.swift
//  KMM_Showcase
//
//  Created by Edgars Simanovskis on 22/3/2565 BE.
//  Copyright © 2565 BE orgName. All rights reserved.
//

import SwiftUI

struct JobDetailsView: View {
    var jobDetails = "Job Detail"
    
    var body: some View {
        NavigationView {
            VStack {
                Spacer()
                BottomView()
            }
            .ignoresSafeArea()
        }
        .navigationBarBackButtonHidden(true)
        .navigationBarItems(leading: BackButton(text: jobDetails))
        
    }
}

struct BottomView: View {
    var description = "Get this job to know more about farmer contact information"
    var price = "80-95 Baht"
    var body: some View {
        VStack {
            Text(description)
                .fontWeight(.semibold)
                .padding(.top)
            HStack {
                Text("Price")
                    .fontWeight(.light)
                Spacer()
                Text(price)
                    .font(.title3)
                    .fontWeight(.bold)
                    .foregroundColor(.greenColor)
            }
            .padding()
            Button("Accept", action: {})
                .buttonStyle(FatGreenButton())
                .padding()
                .padding(.bottom)
        }
        .padding()
        .background(Color.white)
        .cornerRadius(40)
        .overlay(
            RoundedRectangle(cornerRadius: 40)
                .stroke(Color.gray.opacity(0.2), lineWidth: 1)
        )
    }
}

struct JobDetailsView_Previews: PreviewProvider {
    static var previews: some View {
        JobDetailsView()
    }
}
